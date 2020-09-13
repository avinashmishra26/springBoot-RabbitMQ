springBoot+Rabbit
====================

1. Installation of rabbit is mandatory before starting this project.

    For Mac Users :
    a) brew install rabbitmq

    b) Inside the .bash_profile file add the following lines
        #HOME RABBITMQ
        export RABBITMQ_HOME=/usr/local/Cellar/rabbitmq/3.8.3/sbin/
        export PATH=$PATH:$HOMEBREW_RABBITMQ


    c) Start RabbitMQ server
       	cd /usr/local/Cellar/rabbitmq/3.8.3/sbin
       	$ ./rabbitmq-server

    d) RabbitMQ web dashboard
        http://localhost:15672

2. This project contains example based on Direct & Topic exchanges because these are mostly used in industry.

    Fanout Exchange, Headers Exchange or Dead Letter Exchange are not included.
