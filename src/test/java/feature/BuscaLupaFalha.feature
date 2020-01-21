#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Ação de buscar um produto que não exista

  Cenário: Buscar um produto que não exista
    Dado Que o usuário esteja na tela principal
    Quando Clica no botão da lupa
    E Digita o nome do tipo do produto "mochila"
    Mas o produto não é encontrado
    Então valida mensagem de produto não encontrado
