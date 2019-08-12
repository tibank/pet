For connecting to DB you should add next elements to the file conf\context.xml
in tag <Context>.
Replace username and password with yours.

    <Resource name="jdbc/PetDB"
              auth="Container"
              type="javax.sql.DataSource"
              username="root"
              password="root"
              driverClassName="org.mariadb.jdbc.Driver"
              url="jdbc:mariadb://localhost:3306/pet?serverTimezone=UTC"
              maxTotal="8"
              maxIdle="4"/>
              
After using liquibase there is one user admin with e-mail 'admin@admin.com' and password 123456
and there are four categories of products.
There is sql-script 'products.sql' for insert some products to DB for demo. This file is in the 
resources.