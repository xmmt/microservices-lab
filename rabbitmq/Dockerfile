#FROM bitnami/rabbitmq:latest
#ENV RABBITMQ_USER student
#ENV RABBITMQ_PASSWORD hello
#ADD init.sh /init.sh
#EXPOSE 5672 15672
#CMD ["sudo", "chmod", "777", "/init.sh"]
#CMD ["sudo", "/init.sh"]

FROM rabbitmq

#FROM bitnami/rabbitmq:3.8

# Define environment variables.
ENV RABBITMQ_USER user
ENV RABBITMQ_PASSWORD user
ENV RABBITMQ_PID_FILE /var/lib/rabbitmq/mnesia/rabbitmq

ADD init.sh /init.sh
RUN chmod +x /init.sh
#EXPOSE 5672 15672

# Define default command
CMD ["/init.sh"]
