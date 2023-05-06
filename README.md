# jwtSecurity
Sistema de criptografia de senha, autenticação de usuário e geração de token para o sistema Marmita Social.

Frameworks: <br>
Spring Boot<br>
Spring Security<br>
JWT<br>
JPA<br><br>
Banco de dados: <br>
Postgres <br>

**OBSERVAÇÃO:** Caso não tenha o Postgres instalado em sua máquina, no arquivo **application.properties** remova tudo que tiver a ver com o Postgres <br> e adicione ao **POM.xml** do projeto a seguinte dependencia:<br>

```
<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>2.1.214</version>
    <scope>test</scope>
</dependency>
```


## Rotas do tipo POST

- Salvar Usuario:  localhost:8080/api/users/<br>

```
 Json:
 {
	"login":"user",
	"password":"password"
}
```
<br><hr>

- Login : localhost:8080/api/users/auth
```
Json:
{
	"login":"mayte",
	"password":"1234",
	"email":"email_email@gmail.com",
	"cep":"70737022",
	"dataNascimento":"2022-05-21",
	"intoleranciaAlimentar": ["lactose", "gluten"],
	"restricaoAlimentar": ["vegano","outro"]
}
```
<br><hr>
