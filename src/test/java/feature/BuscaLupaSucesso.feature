#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Ação de buscar um produto na lupa

  Cenário: Buscar um produto na lupa com Sucesso
    Dado Que o usuário esteja na tela principal
    Quando Clica no botão da lupa
    E Digita o nome do tipo do produto "Speakers"
    E fecha a lista de sugestões 
    E seleciona um produto da lista "Bose Soundlink Bluetooth Speaker III"
    E valida se o produto selecionado e o esperado "Bose Soundlink Bluetooth Speaker III"
    Então busca realizada com sucesso produto encontrado
