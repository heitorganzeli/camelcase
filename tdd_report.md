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

## Ciclo: 2

### Teste Adicionado

### Código Anterior

### Código Novo

## Ciclo: 3

### Teste Adicionado

### Código Anterior

### Código Novo