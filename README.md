# Cargo Train - Limited Buffer Simulation

![DEMO](https://github.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/blob/demo-video/traint.gif?raw=true)

This is a Java desktop application with a graphical user interface (GUI) built using Swing. The application simulates a cargo train system that solves the classic Producer-Consumer problem by coordinating the transport of boxes between two locations, A and B, using multiple threads and semaphores. The train acts as the consumer, and the packers act as the producers.

## Problem Description:
The cargo train is responsible for transporting boxes filled with products between locations A and B. However, the train must wait until a certain number of boxes, denoted as **_N_**, have accumulated before it departs. Once the required number of boxes is reached, the train transports exactly **_N_** boxes from A to B, then returns to A. If there are additional **_N_** boxes available, the train departs immediately; otherwise, it waits until there are enough boxes.

The boxes are packed by packers, and each packer places a packed box in a depot at the train station. The depot can store up to **_M_** boxes, where **_M ≥ N_**. The packers work continuously, packing boxes and storing them in the depot. If the depot is full, packers attempting to store boxes must wait until space becomes available. The simulation uses semaphores to model the train thread and the packer threads, with potentially many packers and only one train thread.

## Application Components:

### Train Thread:
![Train](https://raw.githubusercontent.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/main/master/src/imagens/trem_comvagao%20(1).png)

The train thread is responsible for transporting the boxes between locations A and B. It has the following attributes:
- **_N_**: The number of boxes that the train must transport at a time.
- **_tv_**: Travel time, representing the time it takes for the train to travel from A to B and vice versa. The user interface displays the status as "traveling from A to B" or "traveling from B to A" during this time.

### Packer Thread:
![Packer](https://raw.githubusercontent.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/main/master/src/imagens/empacotador.png)

The packer threads represent the workers responsible for packing the boxes. Each packer has the following attributes:
- **_id_**: An identifier for the packer.
- **_te_**: Packing time, which is the time it takes for the packer to pack a single box. The user interface displays the status as "packing" during this time.

## Design:
The application has a visually appealing background image inspired by the Sertão of Ceará, featuring a semi-arid climate with Mandacaru (Cacti).

## Minimum Requirements:
- **JRE:** Java Runtime Environment version 15.0.2 or higher.
- **OS:** Windows 10/11 (64-bit Required).
- **Processor:** Dual-Core.
- **Memory:** At least 4GB RAM.

## Installation:
You can download the application in either JAR format or as a ZIP archive:

- [.JAR](https://github.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/blob/JAR/TrainThread.jar)
- [.zip](https://github.com/jbrun0r/Aplica-oJavaThreadsTrain-Projeto/blob/JAR/TrainThread.zip)

## How to Use:
1. Ensure you have Java installed on your system and meet the minimum requirements.
2. Download the application using the provided links.
3. Run the downloaded JAR file.
4. The application will open, and you can interact with the simulation using the graphical user interface.
5. Follow the interface instructions to adjust the number of boxes, packing and travel times, and observe the train and packers' behavior.

Feel free to contribute to the project or report any issues you encounter.

Enjoy the cargo train simulation!
