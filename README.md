# codefellowship

## CodeFellowship that allows people learning to code to connect with each other and support each other on their coding journeys.

## End Ponts => 
 
   - ("/") => Home page.

   - ("/signup") => signup page.

   - ("/signin") => sginin page.

   - ("/myprofile") => user's profile.

   - ("/addPost") => Allos the user to add the post.

   - ("/users") => Displays All the users.

   - ("/user") => Sisplays current user.



   # Dependencies => 

   ```
   
   dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'org.postgresql:postgresql'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
}
   ```