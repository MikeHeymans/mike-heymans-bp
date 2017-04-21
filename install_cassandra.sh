cd /usr/lib/jvm
wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-linux-x64.tar.gz"
sudo tar xzf jdk-8u121-linux-x64.tar.gz
cd /usr/lib/jvm/jdk1.8.0_121/
sudo alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.8.0_121/bin/java 2
sudo alternatives --config java

# add datastax/repo
sudo yum install dsc30
sudo yum install cassandra30-tools

#add cassandra.yaml