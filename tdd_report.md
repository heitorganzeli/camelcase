# Semana 1 - Camel Case

## Ciclo: 1

### Teste Adicionado

```java
@Test
public void testSingleWordLowerCase() {
    String camelCaseString = "nome";
    List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
    assertThat(wordList, equalTo(Arrays.asList("nome")));
}
```

### Código Anterior

No primeiro ciclo não existe código anterior

### Código Novo

```java
static List<String> converterCamelCase(String camelCaseString) {
    return Arrays.asList(camelCaseString);
}
```

### Descrição

Foi criada uma classe com o método especificado que retorna uma lista com a 
palavra passada

## Ciclo: 2

### Teste Adicionado

```java
@Test
public void testSingleCaptalizedWord() {
    String camelCaseString = "Nome";
    List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
    assertThat(wordList, equalTo(Arrays.asList("nome")));
}
```

### Código Anterior

```java
static List<String> converterCamelCase(String camelCaseString) {
    return Arrays.asList(camelCaseString);
}
```

### Código Novo

```java
static List<String> converterCamelCase(String camelCaseString) {
    return Arrays.asList(camelCaseString.toLowerCase());
}
```

### Descriçao

Adicionada transformação para lower case. 


## Ciclo: 3

### Teste Adicionado

```java
@Test
public void testComposedWord() {
    String camelCaseString = "nomeComposto";
    List<String> wordList = CamelCase.converterCamelCase(camelCaseString);

    assertThat(wordList, equalTo(Arrays.asList("nome", "composto")));
}
```

### Código Anterior

```java
static List<String> converterCamelCase(String camelCaseString) {
    return Arrays.asList(camelCaseString.toLowerCase());
}
```

### Código Novo

```java
static List<String> converterCamelCase(String camelCaseString) {
    List<String> words = new ArrayList<>();

    int wordStart=0;
    for (int i = 0; i < camelCaseString.toCharArray().length; i++) {
        if ((camelCaseString.toCharArray()[i] >= 'A' && 
                camelCaseString.toCharArray()[i] <= 'Z') &&
                i != wordStart) {

            words.add(camelCaseString.substring(wordStart, i).toLowerCase());
            wordStart = i;
        }
    }
    words.add(camelCaseString.substring(wordStart, camelCaseString.length()).toLowerCase());
    return words;
}
```

### Descriçao

Método simplificado não é mais capaz de resolver a separação de palavras.
Foi adicionado algoritmo para a separação de palavras ao encontrar letras maiúsculas.


## Ciclo: 4

### Teste Adicionado

```java
@Test
    public void testCaptalizedComposedWord() {
        String camelCaseString = "NomeComposto";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        
        assertThat(wordList, equalTo(Arrays.asList("nome", "composto")));
    }
    
    @Test
    public void testAcronym() {
        String camelCaseString = "CPF";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        
        assertThat(wordList, equalTo(Arrays.asList("CPF")));
    }
```

### Código Anterior
```java
static List<String> converterCamelCase(String camelCaseString) {
    List<String> words = new ArrayList<>();

    int wordStart=0;
    for (int i = 0; i < camelCaseString.toCharArray().length; i++) {
        if ((camelCaseString.toCharArray()[i] >= 'A' && 
                camelCaseString.toCharArray()[i] <= 'Z') &&
                i != wordStart) {

            words.add(camelCaseString.substring(wordStart, i).toLowerCase());
            wordStart = i;
        }
    }
    words.add(camelCaseString.substring(wordStart, camelCaseString.length()).toLowerCase());
    return words;
}
```

### Código Novo
```java
private static final Pattern acronym = Pattern.compile("[A-Z]+");

static List<String> converterCamelCase(String camelCaseString) {
    List<String> words = new ArrayList<>();

    int wordStart = 0;
    for (int i = 0; i < camelCaseString.toCharArray().length; i++) {
        if ((camelCaseString.toCharArray()[i] >= 'A'
                && camelCaseString.toCharArray()[i] <= 'Z')
                && i != wordStart
                && !(camelCaseString.toCharArray()[i - 1] >= 'A'
                && camelCaseString.toCharArray()[i - 1] <= 'Z')) {

            String word = camelCaseString.substring(wordStart, i);
            if (!acronym.matcher(word).matches()) {
                word = word.toLowerCase();
            }
            words.add(word);
            wordStart = i;
        }
    }
    String word = camelCaseString.substring(wordStart, camelCaseString.length());
    if (!acronym.matcher(word).matches()) {
        word = word.toLowerCase();
    }
    words.add(word);
    return words;
}
```

### Descriçao

Como o primeiro teste adicionado para o ciclo passou, um novo teste teve de ser adicionado.
algumas modificações diveram que ser feitas para considerar o caso de acrônimos.

## Refatoração

### Código Anterior
```java
private static final Pattern acronym = Pattern.compile("[A-Z]+");

static List<String> converterCamelCase(String camelCaseString) {
    List<String> words = new ArrayList<>();

    int wordStart = 0;
    for (int i = 0; i < camelCaseString.toCharArray().length; i++) {
        if ((camelCaseString.toCharArray()[i] >= 'A'
                && camelCaseString.toCharArray()[i] <= 'Z')
                && i != wordStart
                && !(camelCaseString.toCharArray()[i - 1] >= 'A'
                && camelCaseString.toCharArray()[i - 1] <= 'Z')) {

            String word = camelCaseString.substring(wordStart, i);
            if (!acronym.matcher(word).matches()) {
                word = word.toLowerCase();
            }
            words.add(word);
            wordStart = i;
        }
    }
    String word = camelCaseString.substring(wordStart, camelCaseString.length());
    if (!acronym.matcher(word).matches()) {
        word = word.toLowerCase();
    }
    words.add(word);
    return words;
}
```

### Código Novo
```java
private static final Pattern acronym = Pattern.compile("[A-Z]+");

static List<String> converterCamelCase(String camelCaseString) {
    List<String> words = new ArrayList<>();

    for (int i = 0; i < camelCaseString.toCharArray().length; i++) {
        if (shouldBreak(camelCaseString, i)) {

            words.add(formatWord(camelCaseString.substring(0, i)));
            camelCaseString = camelCaseString.substring(i);
        }
    }

    words.add(formatWord(camelCaseString));
    return words;
}

private static boolean shouldBreak(String camelCaseString, int i) {
    return isCapitalLetter(camelCaseString.toCharArray()[i])
            && i != 0
            && !isCapitalLetter(camelCaseString.toCharArray()[i - 1]);
}

private static boolean isCapitalLetter(char c) {
    return c >= 'A' && c <= 'Z';
}

private static String formatWord(String word) {
    if (!acronym.matcher(word).matches()) {
        word = word.toLowerCase();
    }
    return word;
}
```

### Descriçao

Como o método ficou muito longo, uma refatoração precisou ser feita.
repetições foram extraídas em métodos e a legibilidade foi melhorada.


## Ciclo: 3

### Teste Adicionado

```java
```

### Código Anterior

```java
```

### Código Novo

```java
```

### Descriçao

## Ciclo: 3

### Teste Adicionado

```java
```

### Código Anterior

```java
```

### Código Novo

```java
```

### Descriçao
