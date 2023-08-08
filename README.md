# desafioTraduzCEP

## Aplicação que consulta a API 'ViaCEP' e exibe para o usuário os dados de CEPs buscados por ele.

Projeto criado em agosto de 2023 e desenvolvido em resposta ao desafio do curso 
<em>'Java: consumindo API, gravando arquivos e lidando com erros'</em>, da Alura, 
ministrado pelos instrutores <b>Jacqueline Oliveira</b> e <b>Paulo Silveira</b>.

O objetivo do desafio é criar uma aplicação que solicite ao usuário que insira um
CEP que deseja que seja buscado e, a partir da inserção do CEP, a aplicação interaja
diretamente com a API 'ViaCEP', requisitando os dados e informações sobre aquele
determinado CEP.

Ao receber o retorno dos dados em formato JSON, a aplicação então tem a função de
transformar os campos do formato JSON em atributos de um objeto, para, enfim,
exibí-los visualmente e de forma correta para o usuário.

Esse processo ocorre de modo cíclico, até que o usuário defina o encerramento da 
aplicação, momento em que os endereços são gravados em arquivo denominado
'endereços.json'.

Os tópicos discriminados para serem desenvolvidos no desafio foram:

<ol>
<li>Criar uma aplicação para consultar a API ViaCEP</li>
<li>Menu para o usuário informar o CEP para busca</li>
<li>Geração de um arquivo .JSON com os dados do endereço</li>
</ol>

Todos os tópicos acima foram desenvolvidos, buscando sempre preservar a
orientação a objetos. 

Além dos tópicos discriminados anteriormente, foi também incluída uma implementação
para adicionar um valor ao campo 'complemento' do endereço, caso o mesmo se
encontrasse vazio.