FROM node:13.12.0-stretch

WORKDIR /boot-camp/client

# Update packages and install dependency packages for services
RUN apt-get update \
  && apt-get dist-upgrade -y \
  && apt-get clean \
  && echo 'Finished installing dependencies'

# Install npm production packages
COPY package.json /boot-camp/client
RUN cd /boot-camp/client; npm install --production; npm audit fix

COPY . /boot-camp/client

ENV PORT 3000

EXPOSE 3000
