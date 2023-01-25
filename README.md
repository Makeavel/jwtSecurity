# jwtSecurity



Todas as rotas, exceto a de login, necessitam de na header declarar o token do usuário logado para navegar.<br>

Frameworks: <br>
Spring Boot<br>
Spring Security<br>
JWT<br>
JPA<br>


## Rotas do tipo POST

- Login:  localhost:8080/login<br>

Header:<br>
Content-Type       application/json<br>
Authorization Bearer {token} <br>

 Json:<br>
{<br>
	"login":"user",<br>
	"password":"password"<br>
}
<br><hr>
- SalvarUsuario: localhost:8080/api/createUser

Json:<br>
{<br>
	"login":"Amanda",<br>
	"password":"melhorFilha"<br>
}
<br><hr>
- SalvarRoles: localhost:8080/api/role

Json:<br>
{<br>
	"name":"Admin"<br>
}
<br>
## Rotas do tipo GET


- Validação de usuário: localhost:8080/api/validateUser<br>

Header:<br>
Authorization Bearer {token} <br>

Parametros de envio:

login <br>
password <br>
<hr>

- Listar todos usuários:  localhost:8080/api/readAllUsers<br>
<hr>
- Listar todas as Roles: localhost:8082/api/readAllRoles<br>
<hr>
