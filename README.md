<h1 align="center">
  Desafio Mobile 🏅 2023 - Dicionário de Inglês
</h1>




  ## ✏️ Introdução

  Este é um aplicativo de dicionário para o Android. Basicamente, foi criado para o idioma inglês e tem interface simples e intuitiva.
  Você pode adicionar mais palavras na classe de palavras que está sob a atividade principal deste projeto. Eu usei a visualização do RecyclerView para listar as  
  palavras. Além disso, foi adicionado um botão de pesquisa na parte superior da visualização, onde você pode pesquisar uma palavra específica e encontrar seu 
  significado rapidamente.
  



<p align="center">
  <a href="https://media.discordapp.net/attachments/1019265341311963186/1070501163625087057/Original2x.png?width=720&height=221" target="blank"><img src="https://media.discordapp.net/attachments/1019265341311963186/1070501163625087057/Original2x.png?width=720&height=221" width="200" alt="Nest Logo" /></a>
</p>

## Vídeo com apresentação do projeto
[Link de apresentação do projeto](https://www.loom.com/share/a3afb4c6834d43a5a1b899cfadc272dc)

## 📚 Features


Ele fornece as seguintes funcionalidades para o usuário:

- Pesquise as definições de uma palavra em inglês
- Substituição de (Word list) por barra de pesquisa(Adicional)
- O aplicativo Android permite que você procure palavras usando Free Dictionary API
- Salvar palavras nos favoritos(Em processo de criação)
- Funcionalidade de cache offline
- Funcionalidade de conversão de palavras em aúdio
- Design de Tema Claro e Escuro
- Caches e exibição de pesquisas anteriores
- Exibição de palavra, significados e a fonética


  ## 💻 Conceitos usados

 A seguir estão alguns conceitos do Android usados para alcançar as funcionalidades no aplicativo:

- core - funcionalidade central, dados, domínio e camadas de apresentação
- mobile - camada de interface do usuário do aplicativo móvel
- desgaste - camada de interface do usuário do aplicativo de desgaste
- O aplicativo tem uma interface muito simples e interativa que ajuda o usuário a inserir as palavras e obter sua definição em formato de flashcard.
- Recyclerview : Para apresentar a lista de palavras diferentes, usamos o eficiente recyclerview.
- Layout de restrição: todas as atividades no aplicativo usam um layout de restrição flexível, fácil de manusear para diferentes tamanhos de tela.
- Android Studio
- Usando a linguagem Kotlin
- Clean Code e Arquitetura MVVM
- Android framework
- Material Design 
- Significados podem ser acessados através do método GET em qualquer uma das seguintes rotas:
 /[palavra]
 /significados/[palavra]
 /meanings/[palavra]
- LiveData, para dados observáveis
- IU
 
## 📌 Dependencies
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.6.0'
    implementation 'com.google.android.material:material:1.8.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.5.1'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.3'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.3'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'


 <h1 align="center">
 📝Como usar
</h1>
1.Instale o Android Studio: É a plataforma oficial do Google para o desenvolvimento de aplicativos Android. Você pode baixá-lo em https://developer.android.com/studio/.

2.Crie um novo projeto: Abra o Android Studio e selecione "Novo projeto" na tela inicial. Escolha "Aplicativo Android" como tipo de projeto e clique em "Avançar".

3.Configure as opções do projeto: Escolha o nome do seu aplicativo, o nome do pacote, a versão do Android e o diretório de destino. Selecione o "Kotlin" como linguagem de programação e clique em "Criar projeto".

4.Adicione a funcionalidade: Acesse os arquivos do projeto no Android Studio e adicione a funcionalidade desejada aos arquivos Kotlin.

5.Teste o aplicativo: Conecte seu dispositivo Android ou use o simulador do Android Studio para testar o aplicativo. Certifique-se de que tudo está funcionando corretamente.
6. Voce precisará usar a API [Free Dictionary API](https://dictionaryapi.dev/) pra desenvolver este programa.
7. Para criar sua aplicatição utilizando a arquitetura MVVM (Model-View-ViewModel), você precisa seguir os seguintes passos:
- Defina os casos de uso do aplicativo: São as funcionalidades de alto nível que o aplicativo deve ter, como pesquisar palavras, adicionar palavras, editar palavras etc.

- Model: Defina o modelo de dados que o aplicativo precisa manipular, incluindo suas propriedades e métodos.
- View: Crie a interface do usuário que apresentará os dados do modelo para o usuário.
- ViewModel: Escreva o código que irá conectar a View e o Model, expondo as propriedades e os comandos do modelo para a View e atualizando o modelo com as ações do 
  usuário na View.
- Binding: Vincule as propriedades da ViewModel às propriedades da View, para que as alterações feitas na ViewModel sejam automaticamente refletidas na View.
- Implementação: Implemente as funcionalidades restantes do aplicativo, incluindo a lógica de negócios e outros comportamentos.


8. Para implementar o banco de dados SQLite em um aplicativo utilizando a arquitetura MVVM, você precisa seguir estes passos:
- Adicionar a biblioteca SQLite ao seu projeto. Isso pode ser feito baixando o pacote apropriado ou adicionando uma referência a ele em seu arquivo de projeto, 
  dependendo da plataforma e das ferramentas que você está usando.
- Criar um modelo para representar os dados que você deseja armazenar no banco de dados. Este modelo pode ser uma classe simples ou uma classe complexa que representa 
  uma entidade ou relação em seu aplicativo.
- Criar um repositório para gerenciar o acesso aos dados no banco de dados. Este repositório pode ser uma classe que contém métodos para consultar, inserir, atualizar 
  e excluir dados.
- Incluir a lógica para criar e conectar ao banco de dados no momento adequado, por exemplo, quando o aplicativo é iniciado.
- Utilizar o repositório para acessar e manipular os dados armazenados no banco de dados, como consultar, inserir, atualizar e excluir dados, a partir da camada 
  ViewModel.
- Atualizar a ViewModel quando houver alterações nos dados armazenados no banco de dados, para que as alterações sejam automaticamente refletidas na View.

9.  Para criar um arquivo XML, você precisa seguir estes passos:
- Abrir um editor de texto ou um aplicativo de desenvolvimento, como o Visual Studio ou o Android Studio.
- Criar um novo arquivo e salvar com a extensão .xml.
- Definir a estrutura do seu documento XML, incluindo elementos, atributos e valores. Cada elemento é delimitado por tags <>, enquanto os atributos são incluídos - -
  dentro das tags, como <elemento atributo="valor">.
- Incluir dados dentro dos elementos, como texto ou outros elementos.
- Validar o arquivo XML para garantir que ele seja válido e que siga as regras da linguagem XML.
- Exemplo de um arquivo XML simples:
 <?xml version="1.0"?>
<livros>
  <livro>
    <título>O Pequeno Príncipe</título>
    <autor>Antoine de Saint-Exupéry</autor>
    <ano>1943</ano>
  </livro>
  <livro>
    <título>O Lobo da Estepe</título>
    <autor>Herman Hesse</autor>
    <ano>1927</ano>
  </livro>
</livros>
Você pode utilizar o arquivo XML para armazenar configurações, recursos de interface de usuário, dados de aplicativo, entre outros.


## Licença
Android Studio é um ambiente de desenvolvimento integrado para desenvolver para a plataforma Android. Foi anunciado em 16 de Maio de 2013 na conferência Google I/O. Android Studio é disponibilizado gratuitamente sob a Licença Apache 2.0.
(https://support.google.com/android/?hl=pt-BR#topic=7313011).

## Stay in touch

- Author - [@Natalí Dias]
- Plataforma - [@Android Studio](https://developer.android.com/studio/intro?hl=pt-br)

## License
Challenge ♥ by [Coodesh](https://coodesh.com).
