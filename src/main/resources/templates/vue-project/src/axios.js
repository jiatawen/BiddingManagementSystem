import axios from "axios";

axios.defaults.baseURL="http://localhost:80"

const request= axios.create({
    timeout: 5000,
	headers: {
		'Content-Type': "application/json; charset=utf-8"
	}
})
export default request