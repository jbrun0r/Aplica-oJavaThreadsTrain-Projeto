# Trem de Carga - _Buffer Limitado_

![DEMO](https://github.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/blob/demo-video/traint.gif?raw=true)

Aplicação desktop desenvolvida em **_Java_** com widget toolkit GUI: **_Swing_**. Consiste em coordenar o acesso de tarefas (**Threads**) com utilização de **Semáforos** a um buffer compartilhado com capacidade de armazenamento limitada a _N_ itens.

## Problema:
Um trem de carga transporta caixas com produtos entre as
localidades **A** e **B**, mas só quando a quantidade de caixas acumuladas chegar a **_N_**. Inicialmente, o
trem fica parado (_bloqueado_) em A enquanto não houver **_N_** caixas para transportar. Quando a
quantidade de caixas chegar a **_N_**, o trem deve transportar exatamente **_N_** caixas de **A** para **B**, e em
seguida voltar para **A**. Caso existam outras **_N_** caixas, o trem parte imediatamente; caso contrário,
o trem fica parado (_bloqueado_) novamente até que existam as **_N_** caixas. Os produtos a serem
transportados são embalados nas caixas pelos empacotadores; cada empacotador, quando tem
uma caixa pronta, coloca a caixa em um depósito da estação de trem que tem capacidade para
armazenar **_M_** caixas **_(M ≥ N)_**. Cada empacotador trabalha continuamente embalando caixas e
armazenando no depósito. Quando o depósito estiver cheio, os empacotadores que tentarem
armazenar suas caixas devem dormir (_bloqueados_). Usando semáforos, modele o thread trem e o
thread empacotador, lembrando que podem existir muitos empacotadores e apenas um trem.

>#### Buffer:
* **M** = quantidade de caixas que podem ser armazenadas no depósito da estação de trem.

>#### Thread Trem:

<img src="https://raw.githubusercontent.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/main/master/src/imagens/trem_comvagao%20(1).png" width="200px"/>


* **N** = quantidade de caixas que devem ser transportadas pelo trem.\
* **tv** = tempo de viagem (tempo que o trem gasta para viajar de A até B e vice-versa). A
interface deve mostrar que o processo trem está executando durante todo este tempo com o
status “viajando de A para B” ou “viajando de B para A”.
>#### Thread Empacotador:

<img src="https://raw.githubusercontent.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/main/master/src/imagens/empacotador.png" width="30px"/>


* **id** = identificador do empacotador.\
* **te** = tempo de empacotamento (tempo que o empacotador gasta para embalar uma caixa). A
interface deve mostrar que o empacotador está executando durante todo este tempo com o
status “empacotando”.

## Design:
Background:

![fundo](https://github.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/blob/demo-video/fundo.png?raw=true)
Imagem de Fundo desenhada por mim. Clima Semiárido contendo Mandacaru (Cactos). Foi inspirada no Sertão do Ceará.
___

#### Requisitos mínimos:
* **JRE:** 15.0.2
* **SO:** Windows 10/11 (64-bit Required)
* **Processador:** Dual Core
* **Memória:** 4GB de RAM
---
#### Download:

[.JAR](https://github.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/blob/JAR/TrainThread.jar)\
[.zip](https://github.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/blob/JAR/TrainThread.zip)


