FROM nginx
RUN  apt update
WORKDIR /app
COPY . /usr/shere/nginx/html/   
EXPOSE 80
CMD ["nginx", "-g", "daemon off;" ] 