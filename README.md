# inventario-computadores
Inventario de computadores com Java EE para Web usando CDI, JPA, HIBERNATE, JSF.

0 - Classes documentadas;

1 - Baixar o clone no Github;

2 - Abrir a IDE Eclipse e importar um projeto existente Maven;

3 - Depois de importar, se der algum erro, vá a aba de ferramentas Project e navegue até Clean e limpe o projeto;

4 - Vá até o Mysql e crie um banco de dados com o nome (inventario). Configurei o usuário como root e a senha é admin;

5 - Para conferir esta configuração no projeto vá até JPA Content e navegue até persistence.xml;

6 - No Eclipse crie um servidor Apache Tomcat 7.0 ou 8.0 e suba o servidor e faça o Deploy do Projeto;

7 - Não é necessário criar a tabela Fabricante o Hibernate vai fazer isso pra vc;

8 - O CRUD do Fabricante e ModeloComputador estão funcional, acrescentei também a categoria que um Enum;

9 - End Pesquisa de Fabricantes localhost:8080/inventario-computadores/fabricante/PesquisaFabricantes.xhtml
