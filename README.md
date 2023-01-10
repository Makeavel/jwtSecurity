# jwtSecurity

Todas as rotas, exceto a de login, necessitam de na header declarar o token do usuário logado para navegar.


## Rotas do tipo POST

Header:<br>
Content-Type       application/json<br>
Authorization Bearer {token} <br><br>

- Login:  localhost:8080/login

 Json:<br>
{<br>
	"login":"user",<br>
	"password":"password"<br>
}
<br>
- SalvarUsuario: localhost:8080/api/createUser

Json:<br>
{<br>
	"login":"Amanda",<br>
	"password":"melhorFilha"<br>
}

## Rotas do tipo GET

Header:<br>
Authorization Bearer {token} <br><br>

- Validação de usuário: localhost:8080/api/validateUser

Parametros de envio:

login <br>
password <br>

- Listar todos usuários:  localhost:8080/api/readAllUsers
