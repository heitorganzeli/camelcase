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

### Código Anterior

### Código Novo

### Descriçao

## Ciclo: 3

### Teste Adicionado

### Código Anterior

### Código Novo

### Descriçao

## Ciclo: 3

### Teste Adicionado

### Código Anterior

### Código Novo

### Descriçao
