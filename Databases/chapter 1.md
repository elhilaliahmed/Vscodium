# Chapter 1:
## Outline:
- Introduction
- An Example
- Characteristics of the Database Approach
- Actors on the Scene
- Workers behind the Scene
- Advantages of Using the DBMS Approach

# 1.1 Introduction:
- A database is a collection of related data. By ***data**, we mean knwon facts that can be recorded and that have implicit meaning. For example, consider the names, telephone numbers, and addresess of the people you know. You may have recorded this data in an indexed address book or you may have stored it on a hard drive, using a personal computer and software such as Microsoft Acess or Excel. This collection of related data with an implicit meaning is a database.

## Data vs Infomation:
- Information is the result of processing and analyzing data. For example recording temperature, humidity, wind speed... is recording data, we can store somewhre, but after analyzing by using certain methods we can predict the weather, that's what we call **information**.

- A database represents some aspect of the real world, sometimes called the ***miniworld*** or the ***universe of discourse*** (***UoD***). Changes to the miniworld are reflected in the database.
## Example:
- In database, we record a teacher name, date of recuitment, and salary, if we the salary of the teacher inceases, we should update the database to make representative of the real world.

- A database is a logically coherent collection of data with some inherent meaning. A random assortment of data cannot correctly be referred to as a database.
- A database is designed, built, and populated with data for a specific purpose. It has an intended group of users and some preconceived applications in which these users are interested.

## Database Examples:
- **Traditional database applications**
  - Store textual or numeric information.
- **Multimedia databases**
  - Store images, audio clips, and video streams digitally.
- **Geographic information systems (GIS)**
  - Store and analyze maps, weather data, and satellite images.
- **Data warehouses and online analytical processing (OLAP) systems**
  - Extract and analyze useful business information from very large databases.
  - Support decision making.

## **Database Management system (DBMS)**:
- ***A database management system (DBMS)*** is a collection of programs that enables users to create and maintain a database. The DBMS is a general-purpose software system that facilitates the processes of defining, constructing, manipulating, and sharing databases among various users and applications.
  - ***Defining*** a database involves specifying the data types, structures, and constraints of the data to be stored in the database. The database definition or descriptive information is also stored by the DBMS in the form of a database catalog or dictionary, it is called ***meta-data*** (*data about data*).
  - ***Constructing*** the database is the process of storingthe data on some storage medium that is controlled by the DBMS.
  - ***Manipulating*** a database includes functions such as querying the database to retrieve specific data, updating the database to reflect changes in the miniworld, and generating reports from the data.
  - ***Sharing*** a database allows multiple users and programs to access the database simultaneously.
  - An ***application program*** accesses the database by sending queries or requests for data to the DBMS.
  - A ***query*** typically causes some data to be retrieved.
  - ***Transaction*** may cause some data to be read and some data to be written into the database.

- Other important fucntions provided by the DBMS include protecting the database and maintaining it over a long period of time. ***Protection*** includes system protection against hardware or software malfunction (or crashes) and security protection against unauthorized or malicious access.
- A typical large database may have a life cycle of many years, so the DBMS must be able to ***maintain*** the database system by allowing the system to evolve as requirements change over time.