<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="creationUser">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="nameUser">Firstname <span class="requis">*</span></label>
                    <input type="text" id="nameUser" name="nameUser" value="" size="20" maxlength="20" />
                    <br />
                   
    
                    <label for="pwdUser">Password <span class="requis">*</span></label>
                    <input type="text" id="pwdUser" name="pwdUser" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="mailUser">Email Identification <span class="requis">*</span></label>
                    <input type="email" id="mailUser" name="mailUser" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="codeUser">Code Identification</label>
                    <input type="text" id="codeUser" name="codeUser" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="statusUser">Status</label>
                    <input type="text" id="statusUser" name="statusUser" value="" size="20" maxlength="1" />
                    <br />
                    
                    <label for="dateUser">Date</label>
                    <input type="text" id="dateUser" name="dateUser" value="" size="20" maxlength="20" />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>