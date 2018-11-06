FROM airhacks/glassfish
COPY ./target/Atencion-Tickets.war ${DEPLOYMENT_DIR}
