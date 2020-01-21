#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Ação de buscar um produto na lupa

Contexto: 
    Dado Que o usuário esteja na tela principal
    Quando Clica no botão da lupa
    

@Test1
  Cenário: Buscar um produto na lupa com Sucesso
    E Digita o nome do tipo do produto "Speaker"
    E fecha a lista de sugestões 
    E seleciona um produto da lista "Bose Soundlink Bluetooth Speaker III"
    Então busca realizada com sucesso produto encontrado "Bose Soundlink Bluetooth Speaker III"

@Test2
  Cenário: Buscar um produto que não exista
    E Digita o nome do tipo do produto "mochila"
    Então valida mensagem de produto não encontrado "mochila"
