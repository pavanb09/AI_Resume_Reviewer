import { useState } from "react";
import axios from "axios";

const Review = () =>{

    const [data, setData] = useState("");
    const [resume,setResume] = useState("");
    const [loading,setLoading] = useState(false);
    const [color, setColor] = useState("green");




    const handleSubmit = async (e)=>{
        e.preventDefault(); 
        try{
            setLoading(true);

            if(!resume.trim()) return;

            const res = await axios.post(
                         "https://ai-resume-reviewer-br0r.onrender.com/api/review",
                        { resumeText: resume }
            );
            console.log(res.data);
            setData(res.data.data.feedback);
            setColor("green");
        }catch(error){
            
            setData("Something went wrong........")
            setColor("red");

        }finally{
            setLoading(false);
        }

    }

    const handleClear = ()=>{
        setData("");
        setResume("")
    }

    

    return(
        <>
        <h1>AI Resume Reviewer</h1>

        <form onSubmit={handleSubmit} >

            <label htmlFor="resume">Drop Resume</label><br />

            <textarea name="resume"
                rows={10}
                cols={50}
                id="resume" 
                onChange={(e)=>setResume(e.target.value)}
                placeholder="Drop your resume here"
                value={resume}
                ></textarea><br /><br />

        <div className="buttons">
            <button type="submit">
                {loading ? "Submiting...":"Submit"}
                </button>
            <button type = "reset" onClick={handleClear}> Clear</button>
        </div>
            
        </form>
        
        {data &&
        <div className="result-container">
            <pre
            style={{"color":color}}
            >{data} </pre>
        </div>}
        </>
    )

}

export default Review;