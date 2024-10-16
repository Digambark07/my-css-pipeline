From nginx 
WORKDIR /opy
RUN  apt-get update 
copy . /usr/share/nginx/html/
EXPOSE 80
CMD [ "nginx","-g","daemon off;" ]
