const fs = require('fs');
var prompt = require('prompt');

  prompt.start();

  prompt.get(['lienModels', 'auteur'], function (err, result) {
    files = fs.readdirSync(result.lienModels);//, (err, files) => {

      console.log(files);
      files.forEach(file => {
        let tablename = file.replace(".java","");
        fs.readFile('./template/[*table*]Dao.java', function(err, data){
          if(err) return console.log(err);
          content = data.toString().replace(/\[\*table\*\]/g,tablename);
          content = content.replace(/\[\*Auteur\*\]/g, result.auteur);

          fs.writeFile('./dao/'+tablename+'Dao.java', content);
        });

        fs.readFile('./template/Jpa[*table*]Dao.java', function(err, data){
          if(err) return console.log(err);
          content = data.toString().replace(/\[\*table\*\]/g,tablename);
          content = content.replace(/\[\*Auteur\*\]/g, result.auteur);

          fs.writeFile('./dao/Jpa'+tablename+'Dao.java', content);
        });

        fs.readFile('./template/Dao.java', function(err, data){
          content = data.toString().replace(/\[\*Auteur\*\]/g, result.auteur);
          fs.writeFile('./dao/Dao.java', content);
        });

        fs.readFile('./template/Dao.java', function(err, data){
          content = data.toString().replace(/\[\*Auteur\*\]/g, result.auteur);
          fs.writeFile('./dao/Dao.java', content);
        });
        ///fs.createReadStream('./template/DaoFactory.java').pipe(fs.createWriteStream('./dao/DaoFactory.java'));


        fs.readFile('./template/DaoFactoryJpa.java', function(err, data){
          content = data.toString().replace(/\[\*Auteur\*\]/g, result.auteur);
          fs.writeFile('./dao/DaoFactoryJpa.java', content);
        });

        fs.readFile('./template/PersistenceType.java', function(err, data){
          content = data.toString().replace(/\[\*Auteur\*\]/g, result.auteur);
          fs.writeFile('./dao/PersistenceType.java', content);
        });

        fs.readFile('./template/JpaDao.java', function(err, data){
          content = data.toString().replace(/\[\*Auteur\*\]/g, result.auteur);
          fs.writeFile('./dao/JpaDao.java', content);
        });

      });

    data = fs.readFileSync('./template/DaoFactory.java');//, function(err, data){
    content = data.toString().replace(/\[\*Auteur\*\]/g, result.auteur);
    files.forEach(file => {
        let tablename = file.replace(".java","");
        content = content.toString().replace(/\[\*GetInstanceSignature\*\]/g, "\tpublic abstract Jpa"+tablename+"Dao get"+tablename+"Dao();\n[*GetInstanceSignature*]");
    });

    content =content.toString().replace(/\[\*GetInstanceSignature\*\]/g,"");
    fs.writeFile('./dao/DaoFactory.java', content);

    console.log('-------------------------------------------------')
    console.log("Récupérez les fichiers DAO dans le dossier "+__dirname+"/dao");
    console.log('-------------------------------------------------')
});
