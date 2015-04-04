angular.module('elenco-telefonico')
    .controller('administrationController', function ($scope, $http) {
        $scope.resetPassword = function(userName,mail){
            var url = ['/${build.finalName}','phoneBoockUser',userName,'password'];
            $http.post(url.join('/'),mail);
            $("#createNoncePopup").modal("show");
        };

        $scope.initAdministratorUserList = function(){
            $http.get('/${build.finalName}/phoneBoockUser').
                success(function (data) {
                    $scope.users = data;
                });
        }
});