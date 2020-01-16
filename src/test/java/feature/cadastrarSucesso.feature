#language: pt
#Author: abdiel.cordeiro@rsinet.com.br

Funcionalidade: Ação de Cadastrar
 
Cenário: Cadastrar um usuário com sucesso
 Dado 	O usuário esta na pagina principal
 Quando Navega para o login
 E  		Aperta no botao de cadastrar novo usuário
 E  		Preenche todas as informações
 Então 	volta para janela principal já logado
 
