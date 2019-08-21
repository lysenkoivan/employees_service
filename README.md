## Authorization service
* exposes port 8000
* for Mysql Access access application requires environment variables 
 - DB_HOST, DB_PORT, DB_NAME
 - DB_USERNAME, DB_PASSWORD
* for authorization requires the same secret as auth service, pass as JWT_SECRET
* runs on endpoint /employees
