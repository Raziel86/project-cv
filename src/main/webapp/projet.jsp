<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
 
    <style>
        
            @media (min-width: 576px) {  }


            @media (min-width: 768px) {  }


            @media (min-width: 992px) {  }


            @media (min-width: 1200px) {  }
        body {

            display: flex;
            height: 100%;
            width: 100%;
            flex-direction: row;
            flex-wrap: wrap;
            align-items: flex-start;


        }
        .h1{
             height: 100%;
        }


        
        
       
        .cv {
              display: flex;
              align-items: center;
        }
        .placement {
            
        }

        .placement1 {
           
        }

        .place {
            align-self: flex-end;

        }

        .fl{
           float: left ;
        }
        .fr{
            float: right;
        }

        .dn {
            display: none;
        }
        .t{
              width: 50%;
        }
        .t1{
            width: 400px;
        }
        .t2{
            width: inherit;
        }
        .ta{
             width: auto;
        }
        .t3{
          width: 600px;
        }
        .paddingzone{
            
        padding-top: 100px;
        }
    </style>



</head>

<body style="background-image: url('wpb.jpg');">

 <div class="container paddingzone">
   
    <div class="row">
       <!-- BLOCK 1 vvvvvvvvvvvvvvvvvvv-->
        <div class="col">
            <div class="d-block p-2 text-white mx-auto "><h3>Bienvenue Voyageur !</h3><br><h4>site de creation de CV interactif!</h4></div>
            <div class="d-block p-2  text-white t2 mx-auto"><p class="">Bienvenue sur ce site de creation de CV interactif ! Nous esperons que ce site vous permetteras de facilité la création et d'augmenter la prestence de votre CV et de votre lettre de motivation. Notre but premier est de vous mettre en avant aupres des recruteurs.</p></div>
            <div class="d-block p-2 rounded bg-dark text-white mx-auto t2"><iframe class="" width="560" height="315" src="https://www.youtube.com/embed/RCMXO9sBIcU" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe></div>
        </div>
     <!-- BLOCK 3 useless vvvvvvvvvvvvvvvvvvv-->
    
        <div class="col "> </div>
          <!-- BLOCK 2 vvvvvvvvvvvvvvvvvvvv-->
            <div class="col cv ">
     
                <!-- VVVVV FORMULAIRE D'INSCRIPTION -->
                <div class="d-flex p-2 bg-dark text-white rounded justify-content-center mx-auto t1 ">
                    <div>
                        <form class="px-4 py-3" Methode="get" action="ConfirmationConnection">
                            <div class="form-group wrap-input100 validate-input" data-validate="Svp mettre un Pseudo">
                                <label for="Email">Email</label> <input type="text" class="form-control" name="Email_c" id="Email" placeholder="Voldemort@hogwarts.sp">
                            </div>
                            <div class="form-group wrap-input100 validate-input" data-validate="Svp mettre un mot de passe">
                                <label for="mdp">Password</label> <input type="password" class="form-control" name="mdp_c" id="mdpc" placeholder="Password">
                            </div>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="dropdownCheck"> <label class="form-check-label" for="dropdownCheck"> Se souvenir de moi </label>
                            </div>
                            <button type="submit" class="btn btn-primary">Connection</button>
                        </form>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item text-white" href="inscription">Nouveau ici ? S'inscrire.</a> <a class="dropdown-item text-white" href="#">mot de passe ou pseudo oublié
							?</a>
                    </div>
                </div>
                <!-- ^^^^^^ FORMULAIRE D'INSCRIPTION -->
                
                
            </div>
            
        
   </div>

</div>
</body>

</html>
