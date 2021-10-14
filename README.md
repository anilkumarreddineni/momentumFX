# springboot-javafx-tutorial
Show you how to Integrate Spring Boot with JavaFX  - Tutorial

Specifically shows you how to integrate Spring with JavaFX 8 via Spring Boot.
Describes how to use Spring as the main Java FX Controller Factory and
how to use @Autowired into your Java FX Controllers to get access
to your other Spring Services (@Service) and beans (either via @Component or
JavaConfig @Configuration).

The example also showcases how you can take advantage of Spring Test for
you Integration tests.

You can follow along via notification.fs Java's YouTube Video Tutorial 
"Integrating Spring Boot with JavaFX" https://youtu.be/hjeSOxi3uPg




echo "# JavaFX" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/anilkumarreddineni/devToolsFX.git
git push -u origin main

git remote add origin https://github.com/anilkumarreddineni/devToolsFX.git
git branch -M main
git push -u origin main

install trayTester jar:
mvn install:install-file -Dfile=lib/trayTester-1.0.jar -DgroupId=tray.notification -DartifactId=trayTester -Dversion=1.0 -Dpackaging=jar
