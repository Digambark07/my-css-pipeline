FROM nginx
RUN  apt-get update
WORKDIR /app
COPY . /usr/share/nginx/html/   
EXPOSE 80
CMD ["nginx", "-g", "daemon off;" ] 