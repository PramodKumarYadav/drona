# Reference: https://github.com/markhobson/docker-maven-chrome/blob/master/jdk-8/Dockerfile
    # https://hub.docker.com/_/maven (see for options on what to do here)
    # Reference: https://github.com/markhobson/docker-maven-chrome/blob/master/jdk-8/Dockerfile

# Requirements: To build our environment, the things that are outside our framework and necessary to run tests are:
    # A machine to run our tests
    # JDK
    # Maven
    # Browser(s) of our choice installed on that machine.

# Run instructions:
    # To build a image named drona from this file :  docker image build -t drona . -f Dockerfile
    # To run the container, add framework code in it to run tests as shown here (run in powershell - intellij termminal does not work):
        # cd to this project (needed since we want to map the PWD to usr/src below).
        # docker run --rm -it -v ${PWD}:/usr/src -w /usr/src drona mvn clean test

# This step give us the first three (a linux machine, which has maven and JDK installed)
FROM maven:3.8.1-jdk-11

ARG HERE='/workspace/app'
WORKDIR '/usr/src'

ARG USER_HOME_DIR="/usr"
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# Get latest stable Google Chrome browser (This step installs stable chrome browser for us)
RUN apt-get update || true && apt-get -y install unzip wget curl vim \
 && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
	&& echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
	&& apt-get update -qqy \
	&& apt-get -qqy install google-chrome-stable \
	&& rm /etc/apt/sources.list.d/google-chrome.list \
	&& rm -rf /var/lib/apt/lists/* /var/cache/apt/* \
	&& sed -i 's/"$HERE\/chrome"/"$HERE\/chrome" --headless --disable-dev-shm-usage --no-sandbox/g' /opt/google/chrome/google-chrome

# ChromeDriver
    # This should be downloaded by the project using webdriver manager and thus is not needed to be a part of environment

# The below part should not be part of image (but adding here just for your reference as in what all stuff you will need to add to a running container from this image to make your framework run)
    # Later move this part to docker-compose so that this part remains something for run time and not build time (since src file will continously change)
    #COPY pom.xml .
    #RUN chmod a+rwx -R /usr/
    #COPY src src
    #COPY settings.xml .

# https://github.com/SeleniumHQ/docker-selenium#running-the-images
# When executing docker run for an image that contains a browser please either mount -v /dev/shm:/dev/shm or use the flag --shm-size=2g to use the host's shared memory.
# If not, you will get this error-> org.openqa.selenium.WebDriverException:
                                   #chrome not reachable
# VOLUME /dev/shm

# Keep container running (When running a container from this image)
CMD tail -f /dev/null

