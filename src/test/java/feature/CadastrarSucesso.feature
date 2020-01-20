#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Ação de Cadastrar

  Cenário: Cadastrar um usuário com sucesso
    Dado O usuário esta na pagina principal
    Quando Navega para o login
    E Aperta no botao de cadastrar novo usuário
    E Preenche o seu usuário de login "<username>"
    E Preenche a sua senha "<password>"
    E Preenche a confirmação da senha "<password>"
    E Preenche o seu email "<email>"
    E Preenche o primeiro nome "<firstName>"
    E Preenche o ultimo nome "<lastName>"
    E Preenche o número de telefone "<phonenumber>"
    E Preenche a sua cidade "<city>"
    E Preenche o seu endereço "<address>"
    E Preenche o seu estado "<state>"
    E Preenche o número do seu CEP "<postalCode>"
    E Clica no botão de registrar 
    Então volta para janela principal já logado
