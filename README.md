INSTRUÇÔES DE TESTE
========
Compile o projeto utilizando o Maven, com o seguinte command "mvn clean package"
Dentro da pasta target gerada pelo maven será criado um arquivo chamado "predojo-1.0-SNAPSHOT.jar"

Copie ele e uma pasta chamada "data" para um diretório de sua preferência.

Dentro do diretório data que você copiou, adicione um arquivo chamado matchs.log para que o programa leia suas
informações e exporte um arquivo com o rakings dos jogares em formato CSV ( com separador de cédulas ; ) no mesmo diretório.

Vá até o diretório onde está o jar copiado por você, abra uma linha de comando e excute o comando "java -jar predojo-1.0-SNAPSHOT.jar"
Um arquivo CSV será exportado para pasta "data" abra ele e valide os dados.