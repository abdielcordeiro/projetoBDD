#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Ação de buscar um produto na lupa

Contexto: 
    Dado Que o usuário esteja na tela principal
    Quando Clica no botão da lupa
    

@Test1
  Cenário: Buscar um produto na lupa com Sucesso
    E Digita o nome do tipo do produto
    E fecha a lista de sugestões 
    E seleciona um produto da lista
    Então busca realizada com sucesso produto encontrado

@Test2
  Cenário: Buscar um produto que não exista
    E Digita o nome do tipo do produto inexistente 
    Então valida mensagem de produto não encontrado
