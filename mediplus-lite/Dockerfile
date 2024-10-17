
FROM nginx 
WORKDIR /opt
RUN  apt-get update 
COPY . /usr/share/nginx/html/
EXPOSE 80
CMD [ "nginx","-g","daemon off;" ]
