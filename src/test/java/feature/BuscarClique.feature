#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Buscar produto por categoria

  Contexto: 
    Dado O usuário esta na pagina home buscar produto
    Quando Clicar na categoria desejada
    E selecionar um produto

  @Sucesso
  Cenário: Buscar poduto por categoria com sucesso
    Então Valida se o produto foi selecionado corretamente

  @Falha
  Cenário: Buscar poduto por categoria com falha
    E manda varios produtos para o carrinho
    Então valida se a quantidade que esta no carinho e compativel