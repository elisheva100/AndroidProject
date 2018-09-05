using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataProtocol
{
    public class Cities
    {
        public List<string> MyCities { get; set; }

        public Cities()
        {
            MyCities = new List<string>() { "Eilat", "Mitzpe Ramon", "Beersheba", "Jerusalem", "Tel Aviv", "Hadera", "Tiberias", "Qiryat Shemona" };
        }
    }
}
