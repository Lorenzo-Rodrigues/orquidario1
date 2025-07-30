## Sistema de Orquidário
Minha prioridade foi a integração com serviços da AWS e a criação da pipeline com GitHub Actions para entender melhor o fluxo de CI/CD, mantive simples a API com apenas 1 endpoint,
não fiz testes unitários e nem um handler para as exceções, talvez seja o próximo update.

## Tecnologias
* Java 21
* Spring 
* MongoDB
* S3
* EC2

## O que essa aplicação faz?
Basicamente o usuário pode cadastrar uma nova planta e anexar uma foto.
A foto é salva em um bucket S3 da AWS e a url que acessa essa foto é salva no MongoDB Atlas junto com as outras informações.

## Observações:
Como essa aplicação foi desenvolvida com objetivo de estudo e prática , não vou manter os recursos ativos na nuvem para não gerar custos
mas fique a vontade para fazer sua própria implementação, vou deixar instruções abaixo



## Como implementar?
* Localmente: É necessário logar na AWS e criar seu bucket S3. Depois a sua aplicação também vai precisar de acesso porque será feito a operação de salvar nesse bucket que você criou.
Esse acesso pode ser feito de varias formas mas eu preferi conectar o meu intellij na AWS usando um IAM user. E como é local, ignore o github/workflows/deploy.yml a não ser que queira aproveitar o script para fazer a parte de CI.

* Nuvem: O código atual já está com o setup pra nuvem, mas você vai ter que criar os recursos da AWS primeiro, o S3 e a EC2(eu fiz na mão no console).
E não se esqueça de baixar o Docker e o Java na instancia e configurar o security group. Depois crie as variáveis que estão no arquivo deploy.yml como secrets no GitHub.

## Banco de dados
Acesse sua conta no MongoDB Atlas e crie um cluster, depois, pegue a string de conexão e coloque no seu application.properties substituindo a variável de ambiente pela string pura.
Mas tome cuidado se for comitar pro GitHub porque aparece suas credenciais do MongoDB Atlas.
Outro detalhe: adicione o IP da sua máquina no network access do cluster no Mongo Atlas porque senão a conexão não funciona. 

Caso não queira criar uma conta no MongoDB Atlas você pode subir um container com Docker, tanto localmente como na instancia  EC2,
ai você pode configurar do jeito que quiser, nome do database, password, mapear portas etc, e usar o Mongo Compass pra visualização do DB.
