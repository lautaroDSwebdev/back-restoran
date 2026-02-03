<img width="1059" height="802" alt="image" src="https://github.com/user-attachments/assets/70896aef-6585-4c5e-ac16-a9e816ce3c8a" />
## link swagger http://localhost:8080/swagger-ui/index.html 

# capas de seguridad la aplicacion: 
## filters: "JWTAuthenFilter" capa de autenticacion del usuario y capa de respuesta exitosa de la autenticacion del usuario y generador del token
## security/jwt: "JWTUtilsClass" generacion del token, obtener uno o todos los claims de jwt, , obtencion de firma de la llave de acceso 
## config: "SecurityConfig" configuracion de los permisos de los endpoints cuando el usuario está o no autenticado, 
## encriptado de contraseña, creacion de usuario en memoria para la autenticacion