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


### Código Anterior

### Código Novo
