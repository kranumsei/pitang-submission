# pitang-submission

OBS: PROJETO NÃO ESTÁ MAIS HOSPEDADO VISTO QUE A SELEÇÃO TERMINOU.

- Foi utiliado Java 11 (openjdk 11.0.8 2020-07-14)
- A IDE utilizada foi o Eclipse (Version: 2019-12 (4.14.0) Build id: 20191212-1212)
- A aplicação, esta rondando no servidor de aplicação WildFly (wildfly-20.0.1.Final)
- O unico arquivo de configuração alterado foi o "standalone.xml", o mesmo estara na root do repositorio.
- Estou hospedando na Amazon AWS. (EC2 Instance Ubuntu 18.04.5 server) -> http://ec2-3-133-84-126.us-east-2.compute.amazonaws.com:8080/pitang-submission/
- Banco de dado utilizado foi o H2.


Credenciais de admin:


Email: Admin (é o unico usuario onde o email é apenas um nome)

Password: admin123


-Funcionalidades:
  -Todas as funcionalidades especificadas no pdf foram implementadas.
  
  -O Admin não aparece na listagem de usuarios. Isto é intencional.
  
  -Apenas o Admin pode remover e editar usuarios sem restrições.
  
  -Usuarios comuns conseguem apenas ver a lista de usuarios e editar o proprio nome e/ou adicionar/removar numeros de sua lista.
  
