new Vue({
    el: "#app",
    data: {
        rootUrl: 'http://localhost:8080/api',

        players: [],
        player: {
            id: '',
            fullName: '',
            position: '',
            number: '',
            country: '',
            description: '',
            imageUrl:''
        },
        file: "",



    },
    methods: {
        getPlayers() {
            axios.get(this.rootUrl + '/players').then((resp) => {
                console.log(resp.data);
                this.players = resp.data;
            }).catch((err) => {
                console.log(err);
            })
        },
        deletePlayer(id) {
            axios.delete(this.rootUrl + '/players/delete/' + id).then((resp) => {
                    console.log(resp.data);
                    this.players = this.getPlayers();
                })
                .catch((err) => {
                    console.log(err);
                })
        },
        savePlayer() {
            axios.post(this.rootUrl + '/players/add', this.player).then((resp) => {
                this.player = {};
                this.players = this.getPlayers();
            }).catch((err) => {
                console.log(err);
            })
        },
        getPlayer(id) {
            axios.get(this.rootUrl + '/player/' + id).then((resp) => {
                this.player = resp.data;
            }).catch((err) => {
                console.log(err);
            })
        },
        uploadFile(id) {
            let formData = new FormData();
            formData.append("file", this.file);
            axios.post(this.rootUrl + '/player/image/' + id, formData, {
                    headers: {
                        'content-type': 'multipart/form-data',
                    }
                })
                .then((resp) => {
                    console.log("Success!" + resp.status);
                    this.players = this.getPlayers();

                })
                .catch((err) => {
                    console.log(err);
                })
        },
        selectFile(event) {
            console.log(event.target.files[0]);
            this.file = event.target.files[0];
        }

        /*   submitFile(id) {
               let formData = new FormData();
               formData.append('file', this.file);

               axios.post(this.rootUrl + '/player/image/' + id,
                       formData, {
                           headers: {
                               'Content-Type': 'multipart/form-data'
                           }
                       }
                   ).then(function () {
                       console.log('SUCCESS!!');
                   })
                   .catch(function () {
                       console.log('FAILURE!!');
                   });
           }*/
    },
    mounted() {
        this.getPlayers();
    }
})
