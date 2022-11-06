import './Footer.css';
import {BsFacebook} from 'react-icons/bs';
import {FaLinkedinIn} from 'react-icons/fa';
import {BsInstagram} from 'react-icons/bs';
import {AiOutlineTwitter} from 'react-icons/ai';

const Footer =() =>(
    <div className="footer"> 
        <p>© 2022 Digital Booking</p> 
        <ul className="f-list">
            <li><BsInstagram size={20}/></li>
            <li><AiOutlineTwitter size={20}/></li>
            <li><FaLinkedinIn size={20}/></li>
            <li><BsFacebook size={20}/></li>
        </ul>
    </div>); 


export default Footer; 