# LocationSearch
- Team Magnita Project (Team 7)

# About
- This is the Web Application for displaying an interesting place near the input location. 
- When run the application, the log in page shows up to check the user credential. 
- User may create account using the hyperlink that is located in lower left.

# Running the Application
- The app is already deployed using Google cloud platform. Use link below
- https://directed-post-326819.uc.r.appspot.com/

# Codes for Application
- The application is built using springboot as framework.
	- Back End File Location
		- src/main/java
			- Intereseting Place Algorithm : InterestingPlacesController.java 
			- Storage of Getter and Setter : InterestingPlace.java
			- SpringBoot Framework 	  : InterestingPlacesApp.java
			- Authentication Algorithm     : AuthMangaer.java
			- Authentication Response-back : UserAuthController.java

	- Front End File Location
		- src/main/resources/static
			- Login Page : index.html
			- Create Account Page : create_account.html
			- Search Web App Page : locationSearch.html

	- App Engine
		- src/main/resources/appengine
			- App Engine : app.yaml