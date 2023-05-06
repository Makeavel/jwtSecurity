# jwtSecurity
Sistema de criptografia de senha, autenticação de usuário e geração de token para o sistema Marmita Social.

Frameworks: <br>
Spring Boot<br>
Spring Security<br>
JWT<br>
JPA<br>


## Rotas do tipo POST

- Login:  localhost:8080/api/users/<br>

 Json:<br>
{<br>
	"login":"user",<br>
	"password":"password"<br>
}

<br><hr>

- SalvarUsuario: localhost:8080/api/users/auth

Json:<br>
{<br>
	"login":"mayte",<br>
	"password":"1234",<br>
	"email":"email_email@gmail.com",<br>
	"cep":"70737022",<br>
	"dataNascimento":"2022-05-21",<br>
	"intoleranciaAlimentar": ["lactose", "gluten"],<br>
	"restricaoAlimentar": ["vegano","outro"]<br>
}
<br><hr>
