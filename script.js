const testFolder = './models/';
const fs = require('fs');
var prompt = require('prompt');

  //
  // Start the prompt
  //
  prompt.start();

  //
  // Get two properties from the user: username and email
  //
  prompt.get(['lienModels'], function (err, result) {
    //
    // Log the results.
    //

    fs.readdir(result.lienModels, (err, files) => {
      files.forEach(file => {
        let tablename = file.replace(".java","");
        fs.readFile('./template/[*table*]Dao.java', function(err, data){
          if(err) return console.log(err);

          fs.writeFile('./dao/'+tablename+'Dao.java', data.toString().replace(/\[\*table\*\]/g,tablename));
        });

        fs.readFile('./template/Jpa[*table*]Dao.java', function(err, data){
          if(err) return console.log(err);

          fs.writeFile('./dao/Jpa'+tablename+'Dao.java', data.toString().replace(/\[\*table\*\]/g,tablename));
        });

        fs.createReadStream('./template/Dao.java').pipe(fs.createWriteStream('./dao/Dao.java'));
        fs.createReadStream('./template/DaoFactory.java').pipe(fs.createWriteStream('./dao/DaoFactory.java'));
        fs.createReadStream('./template/DaoFactoryJpa.java').pipe(fs.createWriteStream('./dao/DaoFactoryJpa.java'));
        fs.createReadStream('./template/PersistenceType.java').pipe(fs.createWriteStream('./dao/PersistenceType.java'));
        fs.createReadStream('./template/JpaDao.java').pipe(fs.createWriteStream('./dao/JpaDao.java'));
      });

              console.log('-------------------------------------------------')
              console.log("Récupérez les fichiers DAO dans le dossier "+__dirname+"/dao");
              console.log('-------------------------------------------------')
    })
});
