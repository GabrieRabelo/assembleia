# assembleia
**Dependencias**
* Java 8
* PostgreSQL 11.5

**Configurando banco de dados local**

Para criar um banco de dados local com postgreSQL instalado rode o seguinte comando:

`sudo -u postgres psql -c 'CREATE DATABASE assembleia'`

**Desenvolvimento local**

Para inicializar a aplicação basta utilizar o comando

`./gradlew bootrun`

**Documentação da API**

Para ter acesso aos endpoints basta entrar na URL 

`/swagger-ui.html#/`
