Projeto de BDD para avaliação

Projeto desenvolvido em cima do site http://www.advantageonlineshopping.com/#/ para realização de alguns cenarios de testes.

Cenários: 
A. Cadastrar cliente. 
B. Consultar(Massa de Dados) produto tela principal. 
C. Consultar produto pelo campo de pesquisa.

3- Critérios de aceite : 
A. Demostrar um relatório (a sua escolha “Report”) mostrando as informações dos testes (falhou, passou, etc); 
B. Utilizar em pelo menos um dos cenários consumo da massa de dados via Excel; 
C. Demonstrar as automações funcionando; 
D. Print para todos os cenários(Sucesso/Falha).

->Report escolhido para demonstrar os casos de falha e sucesso foi o reportExtend.
-> nome dos pacotes foi definidos como: br.com.rsinet.HUB_BDD.*


Descrição dos pacotes: 
  -> cucumberTest: Pacote no qual contem o meu TestRunner classe responsavel por configurar o cucumber e dizer como seram executados os teste e em qual ordem dever rodar, todas configuração aqui definidas são aplicadas nas features.

  -> dataProvider: Classe responsavel por saber como lidar e ler o arquivo de .properties ler cada linhas e saber aplicar suas configurações.
  
  -> Managers: Classe responsavel por saber aplicar o que foi definido na classe dataProvider, esta classe contem metodos estaticos os quais manipular os dados obtidos pela data para que o acesso não seja feito diretamente a dataProvider. Realizando a criação de um novo arquivo caso ele já não existe ou não possa mais ser utilizado.

  -> pageFactory: Pacote no qual estão todas as minhas pagesFactory's arquivos que são responsaveis por mapear e saber como executar as funções(escrita,leitura ou clique) nos elementos da páginas, o criterio para criação de uma factory foi quando era alterado a URL ou os métodos são muito distintos.
  
  -> stepDefinitons: Pacote que contém todas as minhas step que sabem como executar os testes, não sabem como manipular um excel nem como encontrar um elemento na página porém responsavel por chamar quem realiza estas funções.

  -> testData: Pacote onde esta guardando meu arquivo excel, onde estão minha massa de dados.
  
  -> utility: Pacote onde estão todos os meus métodos que são reutilizados varias vezes: 
      1-> DriveFactory: Arquivo que controla a criação e destruição das páginas WEB como também recebe a URL que sera executada no navegador 
      2-> Constant: Arquivo no qual foi colocado todas as variaveis que seram constantes na programação, como URL, local do arquivo da massa de dados, celula na qual estão cada variavel. 
      3-> ExcelUtils: Arquivo no qual sabe manipular e extrair as informações do excel( Massa de Dados ). 
      4-> print: Arquivo no qual sabe manipular os print como tirar um print e onde deve salvar o mesmo.
      5-> MassaDados: arquivo que sabem como obter os dados dos excel com os métodos get.
      
   -> Feature: Pacote no qual contém todas as minhas historias de usuário como os cenários que devem ser testados.
   
Foi criado um pasta na raiz do projeto com nome de config na qual contém os arquivos de configuração do extendReport e dos arquivos da .properties.

Dentro da pasta target contém os meus relatorios dos textes como também os print's obtidos nos textes.
