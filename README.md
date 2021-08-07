# jmeter-tests-master
Log into your GitLab account.


Click on new project and select "Run CI/CD for external repo".


On the next page, enter your GitHub repository URL:https://github.com/abidkidwai786/jmeter-tests-master.git, name your project and project SLUG NAME and create the project.
Add your LambdaTest username and access key in following files:


      .src/main/java/BaseClass.java(commit)      
      .src/test/java/Lambdatest.java(commit)     
      .gitlab-ci.yml(commit)     


In the .gitlab-ci.yml file also change gitlab username and the project SLUG NAME(which you will be able to see in the URL of the page you are on) and commit.


Hover on CI/CD tab on the left side and click on pipeline. You'll see the job running and then you can open the LambdaTest platform to see the test.


Note: The job might get on hold with an error message "There are no active runners". For that, you have to go to settings -> CI/CD and expand runners. Then scroll down and turn on shared runner for which your card details details will be needed just for verification purposes.
