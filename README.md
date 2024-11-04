# Triagem Service

## Pré-requisitos

Para rodar a aplicação, você precisa das seguintes ferramentas instaladas:

- **Java 21** (ou outra versão compatível especificada no projeto)
- **Maven 3.8+**
  
### Verificando as Instalações

Para verificar se o Java e o Maven estão instalados corretamente, use os seguintes comandos no terminal:

```bash
java -version
mvn -version
```

### Configuração do Projeto

Clone o repositório para sua máquina local:

```bash
git clone https://github.com/usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

### Rodando a Aplicação
#### Compilação e Execução

Para compilar e rodar a aplicação, use o Maven:

Compilar o projeto:

```bash
mvn clean install
```

Executar a aplicação:

```bash
mvn spring-boot:run
```

Isso iniciará a aplicação no endereço padrão http://localhost:8080.

### Executando Testes

#### Documentação da API

Para acessar a documentação da API:

Após iniciar a aplicação, vá para: "http://localhost:8080/swagger-ui.html" ou importe a collection da pasta resources do projeto no Postman

### Build e Deploy
Para construir um .jar ou .war executável, utilize:

```bash
mvn package
```

O arquivo gerado estará em target/triagem--service-0.0.1.jar

#### Para rodar o .jar manualmente:

```bash
java -jar target/triagem--service-0.0.1.jar
```
